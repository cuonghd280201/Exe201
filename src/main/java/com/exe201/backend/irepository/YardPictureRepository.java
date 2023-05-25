package com.exe201.backend.irepository;

import com.exe201.backend.entity.YardPictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YardPictureRepository extends JpaRepository<YardPictureEntity, Integer> {
    List<YardPictureEntity> getAllByRefIdOrderById(String refId);

    YardPictureEntity findTop1ByRefIdAndImage(String refId, String image);
}
