package com.Backend.Assignment.Tanvir.Util;

public class RedisKeys {

    public static String virality(Long postId) {
        return "post:" + postId + ":virality_score";
    }

    public static String botCount(Long postId) {
        return "post:" + postId + ":bot_count";
    }

    public static String cooldown(Long botId, Long userId) {
        return "cooldown:bot_" + botId + ":human_" + userId;
    }

    public static String notifCooldown(Long userId) {
        return "user:" + userId + ":cooldown";
    }

    public static String notifList(Long userId) {
        return "user:" + userId + ":pending_notifs";
    }
}
