package io.github.yesntttt.tarefasapi.mapper;

import io.github.yesntttt.tarefasapi.dto.UsuarioDTORequest;
import io.github.yesntttt.tarefasapi.dto.UsuarioDTOResponse;
import io.github.yesntttt.tarefasapi.dto.UsuarioNovoCadastradoDTO;
import io.github.yesntttt.tarefasapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario requestToEntity(UsuarioDTORequest request);

    UsuarioDTOResponse entityToResponse(Usuario usuario);

    UsuarioNovoCadastradoDTO entityToUsuarioNovoCadastrado(Usuario usuario);
}
