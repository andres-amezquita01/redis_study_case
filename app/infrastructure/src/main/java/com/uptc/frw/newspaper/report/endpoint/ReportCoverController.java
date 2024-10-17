package com.uptc.frw.newspaper.report.endpoint;

import com.uptc.frw.newspaper.application.reportCover.ReportCoverUseCases;
import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reportCover")
public class ReportCoverController {
    public final ReportCoverUseCases reportCoverUseCases;

    public ReportCoverController(ReportCoverUseCases reportCoverUseCases) {
        this.reportCoverUseCases = reportCoverUseCases;
    }

    @GetMapping()
    public List<ReportCover> getAllReportCovers() {
        return reportCoverUseCases.listAll();
    }

    @GetMapping("/{reportCoverId}")
    public ReportCover getReportCoverById(@PathVariable Long reportCoverId) {
        return reportCoverUseCases.get(reportCoverId).orElseThrow();
    }

    @PostMapping()
    public ReportCover addReportCover(@RequestBody ReportCover reportCover) {
        return reportCoverUseCases.add(reportCover);
    }

    @DeleteMapping("/{reportCoverId}")
    public ReportCover removeReportCover(@PathVariable Long reportCoverId) {
        return reportCoverUseCases.remove(reportCoverId).orElseThrow();
    }

    @PutMapping("/{reportCoverId}")
    public ReportCover updateReportCover(@RequestBody ReportCover reportCover, @PathVariable Long reportCoverId) {
        return reportCoverUseCases.update(reportCover, reportCoverId).orElseThrow();
    }
}
