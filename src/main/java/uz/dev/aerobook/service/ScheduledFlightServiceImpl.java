package uz.dev.aerobook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.dev.aerobook.dto.response.PageableDTO;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.projection.FlightSeatProjection;
import uz.dev.aerobook.repository.FlightSeatRepository;
import uz.dev.aerobook.service.template.ScheduledFlightService;

import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:27
 **/

@Service
@RequiredArgsConstructor
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

    private final FlightSeatRepository flightSeatRepository;

    @Override
    public PageableDTO getScheduledFlightSeats(Long flightId, Integer page) {

        Sort sort = Sort.by(AbsLongEntity.Fields.id).ascending();

        Pageable pageable = PageRequest.of(page, 10, sort);

        Page<FlightSeatProjection> flightSearchProjections = flightSeatRepository.findSeatsByScheduledFlightId(flightId, pageable);

        List<FlightSeatProjection> content = flightSearchProjections.getContent();

        return new PageableDTO(
                flightSearchProjections.getSize(),
                flightSearchProjections.getTotalElements(),
                flightSearchProjections.getTotalPages(),
                !flightSearchProjections.isLast(),
                !flightSearchProjections.isFirst(),
                content
        );

    }
}
