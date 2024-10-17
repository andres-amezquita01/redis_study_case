package com.uptc.frw.newspaper.report.endpoint;

import com.uptc.frw.newspaper.application.report.ReportSubmissionUseCases;
import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reportSubmission")
public class ReportSubmissionController {

    public final ReportSubmissionUseCases reportSubmissionUseCases;

    public ReportSubmissionController(ReportSubmissionUseCases reportSubmissionUseCases) {
        this.reportSubmissionUseCases = reportSubmissionUseCases;
    }

    @GetMapping
    public List<ReportSubmission> getAllReportSubmissions() {
        return reportSubmissionUseCases.listAll();
    }

    @GetMapping("/{repSubId}")
    public ReportSubmission getReportSubmissionById(@PathVariable("repSubId")  Long repSubId) {
        return reportSubmissionUseCases.get(repSubId).orElseThrow();
    }

    @PostMapping()
    public ReportSubmission addReportSubmission(@RequestParam("agencyId") Long agencyId,
                                                @RequestParam("reportId") Long reportId) {

        return reportSubmissionUseCases.add(agencyId, reportId);
    }

    @DeleteMapping("/{repSubId}")
    public ReportSubmission removeReportSubmission(@PathVariable("repSubId")  Long repSubId) {
        return reportSubmissionUseCases.remove(repSubId).orElseThrow();
    }

    @PutMapping()
    public ReportSubmission updateReportSubmission(@RequestParam("id") Long id,
                                                   @RequestParam("agencyId") Long agencyId,
                                                   @RequestParam("reportId") Long reportId) {
        return reportSubmissionUseCases.update(agencyId, reportId, id).orElseThrow();
    }

}
