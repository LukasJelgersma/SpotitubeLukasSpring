package dea.spotitube.spring.spotitubelukasspring.resourceLayer.resources;

import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IPlaylistService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.ITrackService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IUserService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.TrackDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.PlaylistResponseDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistResource {

    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITrackService trackService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<PlaylistResponseDTO> getPlaylists(@RequestParam("token") String token) {
        UserDTO user = userService.getUserByToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.getPlaylists(user));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PlaylistResponseDTO> addPlaylist(@RequestParam("token") String token, @RequestBody PlaylistDTO playlistDTO) {
        UserDTO user = userService.getUserByToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.addPlaylist(user, playlistDTO));
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PlaylistResponseDTO> editPlaylist(@RequestParam("token") String token, @PathVariable int id, @RequestBody PlaylistDTO playlistDTO) {
        UserDTO user = userService.getUserByToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.editPlaylist(user, id, playlistDTO));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<PlaylistResponseDTO> deletePlaylist(@RequestParam("token") String token, @PathVariable int id) {
        UserDTO user = userService.getUserByToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.deletePlaylist(user, id));
    }

    @GetMapping(path = "/{id}/tracks", produces = "application/json")
    public ResponseEntity<TrackResponseDTO> getTracks(@RequestParam("token") String token, @PathVariable int id) {
        UserDTO user = userService.getUserByToken(token);
        PlaylistDTO playlistDTO = playlistService.getPlaylistById(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(trackService.getPlaylistTracks(playlistDTO));
    }

    @PostMapping(path = "/{id}/tracks", produces = "application/json")
    public ResponseEntity<TrackResponseDTO> addTrack(@RequestParam("token") String token, @PathVariable int id, @RequestBody TrackDTO trackDTO) {
        UserDTO user = userService.getUserByToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.addTrackToPlaylist(id, trackDTO));
    }

    @DeleteMapping(path = "/{playlistId}/tracks/{trackId}", produces = "application/json")
    public ResponseEntity<TrackResponseDTO> deleteTrack(@PathVariable int trackId, @PathVariable int playlistId) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.removeTrackFromPlaylist(trackId, playlistId));
    }
}
