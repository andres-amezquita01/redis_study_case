package com.uptc.frw.newspaper.report.endpoint;

import com.uptc.frw.newspaper.application.report.ReportUseCases;
import com.uptc.frw.newspaper.domain.report.entity.Report;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reports")
public class ReportController {

    public final ReportUseCases reportUseCases;

    public ReportController(ReportUseCases reportUseCases) {
        this.reportUseCases = reportUseCases;
    }

    @GetMapping()
    public List<Report> getAllReports() {
        return reportUseCases.listAll();
    }

    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable("reportId") Long reportId) {
        return reportUseCases.get(reportId).orElseThrow();
    }

    @PostMapping()
    public Report addReport(@RequestBody Report report) {
        return reportUseCases.add(report);
    }

    @DeleteMapping("/{reportId}")
    public Report removeReport(@PathVariable("reportId") Long reportId) {
        return reportUseCases.remove(reportId).orElseThrow();
    }

    @PutMapping()
    public Report updateReport(@RequestBody Report report, @RequestParam("reportId") Long reportId) {
        return reportUseCases.update(report, reportId).orElseThrow();
    }

    @PostMapping("/related")
    public void addRelatedReport(@RequestParam("reportId") Long reportId, @RequestParam("relatedId") Long relatedId) {
        reportUseCases.addRelated(reportId, relatedId);
    }

    @DeleteMapping("/related")
    public void removeRelatedReport(@RequestParam("reportId") Long reportId, @RequestParam("relatedId") Long relatedId) {
        reportUseCases.removeRelated(reportId, relatedId);
    }

    @GetMapping("/related/{reportId}")
    public List<Report> getRelatedReportsById(@PathVariable("reportId") Long reportId) {
        return reportUseCases.getRelated(reportId);
    }

}
