package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by jt on 9/25/17.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "testIgnore", ignore = true)
    CategoryDTO categoryToCategoryDTO(Category category);
}
