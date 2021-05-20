package com.ngocdh.facebookimagepicker;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gallery {
    public interface AssetType {
        String ASSET_TYPE_PHOTOS = "Photos";
        String ASSET_TYPE_VIDEOS = "Videos";
        String ASSET_TYPE_ALL = "All";
    }


    public static List<Album> getAlbums(String assetType, Context context) {
        List<Album> listAlbum = new ArrayList<>();

        StringBuilder selection = new StringBuilder("1");
        List<String> selectionArgs = new ArrayList<>();
        if (assetType.equals(AssetType.ASSET_TYPE_PHOTOS)) {
            selection.append(" AND " + MediaStore.Files.FileColumns.MEDIA_TYPE + " = "
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE);
        } else if (assetType.equals(AssetType.ASSET_TYPE_VIDEOS)) {
            selection.append(" AND " + MediaStore.Files.FileColumns.MEDIA_TYPE + " = "
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO);
        } else if (assetType.equals(AssetType.ASSET_TYPE_ALL)) {
            selection.append(" AND " + MediaStore.Files.FileColumns.MEDIA_TYPE + " IN ("
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO + ","
                    + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE + ")");
        }

        final String[] projection = {MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME};

        try {
            Cursor media = context.getContentResolver().query(
                    MediaStore.Files.getContentUri("external"),
                    projection,
                    selection.toString(),
                    selectionArgs.toArray(new String[selectionArgs.size()]),
                    null);
            if (media == null) {
                return listAlbum;
            } else {
                try {
                    if (media.moveToFirst()) {
                        Map<String, Integer> albums = new HashMap<>();
                        do {
                            String albumName = media.getString(media.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME));
                            if (albumName != null) {
                                Integer albumCount = albums.get(albumName);
                                if (albumCount == null) {
                                    albums.put(albumName, 1);
                                } else {
                                    albums.put(albumName, albumCount + 1);
                                }
                            }
                        } while (media.moveToNext());
                        for (Map.Entry<String, Integer> albumEntry : albums.entrySet()) {
                            Album album = new Album(albumEntry.getKey(), albumEntry.getValue());
                            listAlbum.add(album);
                        }
                    }
                } finally {
                    media.close();
                    return listAlbum;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return listAlbum;
        }
    }


}
