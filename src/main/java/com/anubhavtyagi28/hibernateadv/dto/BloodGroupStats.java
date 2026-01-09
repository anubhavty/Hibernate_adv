package com.anubhavtyagi28.hibernateadv.dto;


import com.anubhavtyagi28.hibernateadv.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
