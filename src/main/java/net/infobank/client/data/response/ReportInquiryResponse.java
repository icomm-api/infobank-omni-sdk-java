package net.infobank.client.data.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportInquiryResponse extends ApiResponse{

    ReportInquiryData data;

    public ReportInquiryData getData() {
        return data;
    }

    public void setData(ReportInquiryData data) {
        this.data = data;
    }

    public class ReportInquiryData {

        private List<ReportData> report;

        public List<ReportData> getReport() {
            return report;
        }

        public void setReport(List<ReportData> report) {
            this.report = report;
        }

        @Override
        public String toString() {
            return "report=" + report;
                    
        }
        
    }

    public static class ReportData {

        public ReportData() {}

        String msgKey;
        String ServiceType;
        String msgType;
        String reportType;
        String reportCode;
        String reportText;
        String reportTime;
        String carrier;
        String res;
        String ref;
        
        public String getMsgKey() {
            return msgKey;
        }
        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }
        public String getServiceType() {
            return ServiceType;
        }
        public void setServiceType(String serviceType) {
            ServiceType = serviceType;
        }
        public String getMsgType() {
            return msgType;
        }
        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }
        public String getReportType() {
            return reportType;
        }
        public void setReportType(String reportType) {
            this.reportType = reportType;
        }
        public String getReportCode() {
            return reportCode;
        }
        public void setReportCode(String reportCode) {
            this.reportCode = reportCode;
        }
        public String getReportText() {
            return reportText;
        }
        public void setReportText(String reportText) {
            this.reportText = reportText;
        }
        public String getReportTime() {
            return reportTime;
        }
        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }
        public String getCarrier() {
            return carrier;
        }
        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }
        public String getRes() {
            return res;
        }
        public void setRes(String res) {
            this.res = res;
        }
        public String getRef() {
            return ref;
        }
        public void setRef(String ref) {
            this.ref = ref;
        }

        @Override
        public String toString() {
            
            return "msgKey='" + msgKey + "\'" +
                    ", ServiceType='" + ServiceType + "\'" +
                    ", msgType='" + msgType + "\'" +
                    ", reportType='" + reportType + "\'" +
                    ", reportCode='" + reportCode + "\'" +
                    ", reportText='" + reportText + "\'" +
                    ", reportTime='" + reportTime + "\'" +
                    ", carrier='" + carrier + "\'" +
                    ", res='" + res + "\'" +
                    ", ref='" + ref + "\'";

        }
    }

    public static ReportInquiryResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, ReportInquiryResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce ReportInquiryResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", data={" + data + "}" ;
                
    }


}