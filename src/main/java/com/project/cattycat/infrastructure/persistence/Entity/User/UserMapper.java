package com.project.cattycat.infrastructure.persistence.Entity.User;

import com.project.cattycat.domain.user.Address;
import com.project.cattycat.domain.user.User;
import com.project.cattycat.domain.user.UserId;
import com.project.cattycat.infrastructure.configuration.mapper.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {
    @Mapping(source = "id", target = "id", qualifiedByName = "mapToUserId")
    @Mapping(source = "address", target = "address", qualifiedByName = "mapToAddress")
    User toDomain(UserEntity userEntity);

    @Mapping(source = "id", target = "id", qualifiedByName = "mapToUUID")
    @Mapping(source = "address", target = "address", qualifiedByName = "mapToEmbeddable")
    UserEntity toEntity(User user);

    @Named("mapToUserId")
    static UserId mapToUserId(UUID uuid) {
        return new UserId(uuid);
    }

    @Named("mapToUUID")
    static UUID mapToUUID(UserId userId) {
        return userId.getId();
    }

    @Named("mapToAddress")
    static Address mapToAddress(AddressEmbeddable emb) {
        if (emb == null)
            return null;
        return new Address(emb.getCountry(), emb.getCity(), emb.getZip());
    }

    @Named("mapToEmbeddable")
    static AddressEmbeddable mapToEmbeddable(Address address) {
        if (address == null)
            return null;
        return AddressEmbeddable.builder()
                .country(address.getCountry())
                .city(address.getCity())
                .zip(address.getZip())
                .build();
    }

}
