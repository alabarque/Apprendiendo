package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.TemplateReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TemplateReviewRepository extends JpaRepository<TemplateReview, Long> {
    ArrayList<TemplateReview> findByReviewerId(Long reviewerId);
    ArrayList<TemplateReview> findByTemplateId(Long templateId);
    TemplateReview findByReviewerIdAndTemplateId(Long reviewerId, Long templateId);
}
