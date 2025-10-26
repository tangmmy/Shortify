package com.example.shortify.repos;

import com.example.shortify.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {
}
