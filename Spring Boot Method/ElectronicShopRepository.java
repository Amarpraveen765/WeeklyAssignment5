package com.codingassignment5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ElectronicShopRepository extends JpaRepository<ElecShop,Integer> {

}
