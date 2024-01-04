package nelsonssoares.ecomuserapi.outlayers.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecomuserapi.domain.dtos.EnderecoDTO;
import nelsonssoares.ecomuserapi.domain.entities.Endereco;
import nelsonssoares.ecomuserapi.services.EnderecoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static nelsonssoares.ecomuserapi.constants.ControllersConstants.*;

@Tag(name = API_TAG_ADRESS, description = API_DESCRIPTION)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = API_BASE_URL+ADDRESS, produces = API_PRODUCES)
public class EnderecoController {

    private final EnderecoService enderecoService;


    @Operation(summary = "Metodo para cadastrar novo endereço", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço cadastrado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário!"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> save(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        return enderecoService.salvar(enderecoDTO);
    }



    @Operation(summary = "Metodo para buscar todos os enderecos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Endereco>> obterTodos(Pageable paginacao) {
        return enderecoService.obterTodos(paginacao);
    }



    @Operation(summary = "Metodo para buscar endereço por ID de usuario", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @GetMapping(value = ADDRESS_USER_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Endereco>> obterPorUsuarioId(@PathVariable("id") Integer id) {
        return enderecoService.obterPorUsuarioId(id);
    }


    @Operation(summary = "Metodo Atualizar endereço", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço atualizado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @PutMapping(value = ID)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> atualizar(@PathVariable("id") Integer id, @RequestBody @Valid EnderecoDTO enderecoDTO) {
        return enderecoService.atualizar(id, enderecoDTO);
    }



    @Operation(summary = "Metodo para deletar endereço", method = "Delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deletado com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @DeleteMapping(value = ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Endereco> deletar(@PathVariable("id") Integer id) {
        return enderecoService.deletar(id);
    }



    @Operation(summary = "Metodo para buscar endereço por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busca realizada com sucesso!!"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos!"),
            @ApiResponse(responseCode = "404", description = "Não encontrado!"),
            @ApiResponse(responseCode = "403", description = "Não Autorizado!"),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado!"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválido"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor!"),
    })
    @GetMapping(value = ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable("id") Integer id) {
        return enderecoService.buscarPorId(id);
    }

}
