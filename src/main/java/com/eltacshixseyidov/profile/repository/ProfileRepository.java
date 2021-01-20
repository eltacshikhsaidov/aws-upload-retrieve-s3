package com.eltacshixseyidov.profile.repository;

import com.eltacshixseyidov.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
