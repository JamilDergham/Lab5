package com.example.AddressBook;

import java.util.List;

import com.example.AddressBook.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);
}