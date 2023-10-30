package dea.spotitube.spring.spotitubelukasspring.resourceLayer;

import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;

public interface ITrackService {
    TrackResponseDTO getPlaylistTracks(PlaylistDTO playlistDTO);

    TrackResponseDTO getAllAvailableTracks(PlaylistDTO playlistDTO);
}
