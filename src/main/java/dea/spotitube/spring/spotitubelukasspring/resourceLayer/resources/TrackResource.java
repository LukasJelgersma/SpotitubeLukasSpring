package dea.spotitube.spring.spotitubelukasspring.resourceLayer.resources;

import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IPlaylistService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.ITrackService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IUserService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.PlaylistDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.TrackResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracks")
public class TrackResource {
    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITrackService trackService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<TrackResponseDTO> getTracks(@RequestParam("token") String token, @RequestParam("forPlaylist") int id) {
        UserDTO user = userService.getUserByToken(token);
        PlaylistDTO playlistDTO = playlistService.getPlaylistById(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(trackService.getAllAvailableTracks(playlistDTO));
    }

}
