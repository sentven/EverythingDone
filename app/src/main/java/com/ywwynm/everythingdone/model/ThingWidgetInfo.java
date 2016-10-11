package com.ywwynm.everythingdone.model;

import android.database.Cursor;
import android.support.annotation.IntDef;

import com.ywwynm.everythingdone.Def;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ywwynm on 2016/8/2.
 * thing widget info
 */
public class ThingWidgetInfo {

    public static final int SIZE_TINY   = 0;
    public static final int SIZE_SMALL  = 1;
    public static final int SIZE_MIDDLE = 2;
    public static final int SIZE_LARGE  = 3;

    @IntDef({SIZE_TINY, SIZE_SMALL, SIZE_MIDDLE, SIZE_LARGE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {}

    private int mId;
    private long mThingId;
    private @Size int mSize;
    private int mAlpha; // from 0-100, 0 means transparent and 100 means solid

    public ThingWidgetInfo(int id, long thingId, @Size int size, int alpha) {
        mId = id;
        mThingId = thingId;
        mSize = size;
        mAlpha = alpha;
    }

    public ThingWidgetInfo(Cursor cursor) {
        mId      = cursor.getInt(cursor.getColumnIndex(Def.Database.COLUMN_ID_APP_WIDGET));
        mThingId = cursor.getLong(cursor.getColumnIndex(Def.Database.COLUMN_THING_ID_APP_WIDGET));
        mSize    = cursor.getInt(cursor.getColumnIndex(Def.Database.COLUMN_SIZE_APP_WIDGET));
        mAlpha   = cursor.getInt(cursor.getColumnIndex(Def.Database.COLUMN_ALPHA_APP_WIDGET));
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public long getThingId() {
        return mThingId;
    }

    public void setThingId(long thingId) {
        mThingId = thingId;
    }

    public @Size int getSize() {
        return mSize;
    }

    public void setSize(@Size int size) {
        mSize = size;
    }

    public int getAlpha() {
        return mAlpha;
    }

    public void setAlpha(int alpha) {
        mAlpha = alpha;
    }
}
