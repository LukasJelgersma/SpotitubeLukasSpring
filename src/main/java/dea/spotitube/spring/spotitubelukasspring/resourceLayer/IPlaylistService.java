package dea.spotitube.spring.spotitubelukasspring.resourceLayer;

import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.TrackDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.PlaylistResponseDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;


public interface IPlaylistService {
    PlaylistResponseDTO getPlaylists(UserDTO user);

    PlaylistResponseDTO addPlaylist(UserDTO user, PlaylistDTO playlistDTO);

    PlaylistResponseDTO deletePlaylist(UserDTO user, int id);

    PlaylistResponseDTO editPlaylist(UserDTO user, int id, PlaylistDTO playlistDTO);

    TrackResponseDTO addTrackToPlaylist(int id, TrackDTO trackDTO);

    TrackResponseDTO removeTrackFromPlaylist(int trackId, int playlistId);

    PlaylistDTO getPlaylistById(int id, UserDTO userDTO);

}
