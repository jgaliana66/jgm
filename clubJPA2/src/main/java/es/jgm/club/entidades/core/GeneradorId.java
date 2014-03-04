package es.jgm.club.entidades.core;

import java.util.UUID;

public class GeneradorId
{
    public static String createId()
    {
        UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString();
    }
}
