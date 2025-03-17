package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.types.*;
import dev.neuralnexus.ampapi.auth.AuthProvider;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AnalyticsPlugin extends AMPAPI {
    public AnalyticsPlugin(AuthProvider authprovider) {
        super(authprovider);
    }

    /**
     * Name Description Optional
     * @param PeriodDays 
     * @param StartDate 
     * @param Filters 
     * @return Object
     */
    public Object GetAnalyticsSummary(@Nullable Integer PeriodDays, @Nullable String StartDate, @Nullable Map<String, String> Filters) {
        Map<String, Object> args = new HashMap<>();
        args.put("PeriodDays", PeriodDays);
        args.put("StartDate", StartDate);
        args.put("Filters", Filters);
        Type type = new TypeToken<Object>() {}.getType();
        return this.APICall("AnalyticsPlugin/GetAnalyticsSummary", args, type);
    }


}