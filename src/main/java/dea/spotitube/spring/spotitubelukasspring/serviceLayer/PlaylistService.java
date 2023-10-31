package dea.spotitube.spring.spotitubelukasspring.serviceLayer;


import dea.spotitube.spring.spotitubelukasspring.datasourceLayer.PlaylistDao;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IPlaylistService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.TrackDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.PlaylistResponseDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService implements IPlaylistService {

    private PlaylistDao playlistDao;


    public PlaylistService() {
    }

    /**
     * Get all playlists from user
     * @param user
     * @return PlaylistResponseDTO
     */
    @Override
    public PlaylistResponseDTO getPlaylists(UserDTO user) {


        String username = user.getUser();

        return playlistDao.getPlaylistResponse(username);
    }

    /**
     * Add playlist to user
     * @param user
     * @param playlistDTO
     * @return PlaylistResponseDTO
     */
    @Override
    public PlaylistResponseDTO addPlaylist(UserDTO user, PlaylistDTO playlistDTO) {
        String username = user.getUser();

        playlistDao.addPlaylist(username, playlistDTO);

        return playlistDao.getPlaylistResponse(username);
    }

    /**
     * Delete playlist from user
     * @param user
     * @param id
     * @return PlaylistResponseDTO
     */
    @Override
    public PlaylistResponseDTO deletePlaylist(UserDTO user, int id) {
        String username = user.getUser();

        playlistDao.deletePlaylist(username, id);

        return playlistDao.getPlaylistResponse(username);
    }

    /**
     * Edit playlist from user
     * @param user
     * @param id
     * @param playlistDTO
     * @return PlaylistResponseDTO
     */
    @Override
    public PlaylistResponseDTO editPlaylist(UserDTO user, int id, PlaylistDTO playlistDTO) {
        String username = user.getUser();

        playlistDao.editPlaylist(username, id, playlistDTO);

        return playlistDao.getPlaylistResponse(username);
    }

    /**
     * add track to playlist
     * @param id
     * @param trackDTO
     * @return TrackResponseDTO
     */

    public TrackResponseDTO addTrackToPlaylist(int id, TrackDTO trackDTO) {

        playlistDao.addTrackToPlaylist(id, trackDTO);

        return new TrackResponseDTO(playlistDao.getAllTracks(id));
    }

    /**
     * Delete track from playlist
     * @param trackId
     * @param playlistId
     * @return TrackResponseDTO
     */
    @Override
    public TrackResponseDTO removeTrackFromPlaylist(int trackId, int playlistId) {

        playlistDao.removeTrackFromPlaylist(trackId, playlistId);

        return new TrackResponseDTO(playlistDao.getAllTracks(playlistId));
    }

    /**
     * Get playlist by id
     * @param id
     * @param userDTO
     * @return PlaylistDTO
     */
    @Override
    public PlaylistDTO getPlaylistById(int id, UserDTO userDTO) {
        return (playlistDao.getPlaylistById(id, userDTO.getUser()));
    }


    @Autowired
    public void setPlaylistDao(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

}
