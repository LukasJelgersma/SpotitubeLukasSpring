package dea.spotitube.spring.spotitubelukasspring.serviceLayer;


import dea.spotitube.spring.spotitubelukasspring.datasourceLayer.PlaylistDao;
import dea.spotitube.spring.spotitubelukasspring.datasourceLayer.TrackDao;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.ITrackService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService implements ITrackService {
    private TrackDao trackDao;
    private PlaylistDao playlistDao;

    public TrackService(){

    }

    /**
     * Get all tracks from playlist
     * @param playlistDTO
     * @return TrackResponseDTO
     */
    @Override
    public TrackResponseDTO getPlaylistTracks(PlaylistDTO playlistDTO){
        return new TrackResponseDTO(playlistDao.getAllTracks(playlistDTO.getId()));
    }

    /**
     * Get all available tracks from playlist
     * @param playlistDTO
     * @return TrackResponseDTO
     */
    @Override
    public TrackResponseDTO getAllAvailableTracks(PlaylistDTO playlistDTO){

        return trackDao.getAvailableTracks(playlistDTO.getId());
    }

    @Autowired
    public void setTrackDao(TrackDao trackDao) {
        this.trackDao = trackDao;
    }

    @Autowired
    public void setPlaylistDao(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

}
