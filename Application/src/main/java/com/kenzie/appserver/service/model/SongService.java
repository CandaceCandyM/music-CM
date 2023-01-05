package com.kenzie.appserver.service.model;

import com.kenzie.appserver.repositories.SongServiceRepository;
import com.kenzie.appserver.repositories.model.ExampleRecord;
import com.kenzie.appserver.repositories.ExampleRepository;
import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import com.kenzie.appserver.repositories.model.SongServiceRecord;
import com.kenzie.appserver.service.model.Example;

import com.kenzie.appserver.service.model.SongInfo;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private SongServiceRepository songServiceRepository;

    public SongService(SongServiceRepository songServiceRepository) {
        this.songServiceRepository = songServiceRepository;
    }

    public SongInfo findBySongId(String songId) {
        SongInfo songInfoFromBackend = songServiceRepository
                .findById(songId)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear()))
                .orElse(null);

        return songInfoFromBackend;
    }

    public SongInfo addNewSong(SongInfo songInfo) {
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId(songInfo.getSongId());
        songServiceRecord.setArtistByGenre(songInfo.getArtistByGenre());
        songServiceRecord.setArtistByUserId(songInfo.getArtistByUserId());
        songServiceRecord.setArtistByYear(songInfo.getArtistByYear());
        return songInfo;
    }
}