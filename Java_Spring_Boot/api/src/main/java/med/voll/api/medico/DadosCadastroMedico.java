package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco)
{
    // Essas anotações são do BEAN VALIDATION importadas no site do Start Spring, onde podemos utilizar estes comandos para validar condicionais para armazenar no DB
    // sem precisar ficar colocando no código condicionais como IF e Else
    // @NotNull - É para verificar se o dado não vai vir em branco
    // @NotBlank - É para verificar se o dados não vai ser null ou com espaço vazio ( " " )
    // @Email - Verifica se o dado está vindo no padrão de email
    // @Pattern - Verifica se o dado está vindo em um determinado padrão, para este caso aplicamos um REGEX para verificar
    // se o dado vai vir como número entre 4 e 6 dígitos utilizando entre parentes na frente da marcação (regexp = "\\d{4,6}")
    // @Valid - Serve para validar se os dados do Record criado está sendo validado assim como estamos validando esta Classe Record
    // ou seja todo parametro que extender este Record precisa ter o @valid para validar se todas as condicionais criadas foram
    // validadas com sucesso.
    // Documentação oficial do BEAN VALIDATION https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints
}
