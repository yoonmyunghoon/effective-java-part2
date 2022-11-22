package me.whiteship.chapter04.item16.time;

/**
 * 코드 16-3 불변 필드를 노출한 public 클래스 - 과연 좋은가? (103-104쪽)
 * 7. 필드의 불변은 보장하지만, 필드명 변경에 대한 클라이언트 추가 수정, 부수작업불가 등 단점이 여전히 존재한다.
 */
public final class Time {
    private static final int HOURS_PER_DAY    = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
    }

    // 나머지 코드 생략
}
