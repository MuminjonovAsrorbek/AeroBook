package uz.dev.aerobook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.dev.aerobook.dto.response.PageableDTO;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.projection.FlightSearchProjection;
import uz.dev.aerobook.repository.ScheduledFlightRepository;
import uz.dev.aerobook.service.template.FlightService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 11:40
 **/

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final ScheduledFlightRepository scheduledFlightRepository;

    @Override
    public PageableDTO searchFlights(String fromIata, String toIata, LocalDate date, Integer page) {

        Sort sort = Sort.by(AbsLongEntity.Fields.id).ascending();

        Pageable pageable = PageRequest.of(page, 10, sort);

        Page<FlightSearchProjection> flightSearchProjections = scheduledFlightRepository
                .searchFlights(
                        fromIata,
                        toIata,
                        date,
                        pageable
                );

        List<FlightSearchProjection> content = flightSearchProjections.getContent();

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
