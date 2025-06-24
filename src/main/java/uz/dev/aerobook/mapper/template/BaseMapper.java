package uz.dev.aerobook.mapper.template;

import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:05
 **/

public interface BaseMapper<E, R> {

    E toEntity(R r);

    R toDto(E e);

    List<R> toDto(List<E> e);

}
