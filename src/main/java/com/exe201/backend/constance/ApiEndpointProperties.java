package com.exe201.backend.constance;

public class ApiEndpointProperties {
    public static String[] publicEndpoint = {
            "/api/admin/filter-account",
            "/api/login",
            "/api/register",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/districts/**",
            "/api/provinces/{provinceId}/districts",
            "/api/provinces/**",
            "/api/forgot/send-mail",
            "/api/forgot/confirm-otp",
            "/api/yards/search",
            "/api/yards",
            "/api/yards/{yardId}",
            "/api/slots/get-by-date",
            "/api/sub-yards",
            "/api/sub-yards/**",
            "/api/vote/yards/**",
            "/api/owners/{ownerId}/vouchers",
            "/api/vouchers/{voucherCode}/calculate",
            "/api/logout",
            "/api/vote/yards/{yardId}",

    };
    public static String[] ownerOnlyEndpoint = {
            "/api/owners/me/**"
    };

    public static String[] adminOnlyEndpoint = {
            "/api/admin/owner-register",
            "/api/admin/view-all-user",
            "/api/admin/all-accounts",
            "/api/admin/filter/all-accounts",
            "/api/filter-accounts",
            "/api/admin/accounts/{accountId}",
            "/api/admin/reports",
            "/api/admin/reports/{reportId}",
            "/api/admin/reports/{reportId}/handle",
            "/api/admin/reports/{reportId}/reject"
    };

    public static String[] userOnlyEndpoint = {
            "/api/yards/{yardId}/booking",
            "/api/me/incoming-matches",
            "/api/me/history-booking",
            "/api/me/bookings/{bookingId}",
            "/api/me/report/yards/{yardId}"
    };
}
