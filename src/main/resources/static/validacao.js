function validaCPF(input){
    const cpfFormatado = input.value.replace(/\D/g, '')
    let mensagem = ''

    if(checaCPFRepetido(cpfFormatado)){
        mensagem = 'O CPF digitado não é válido'
    }

    input.setCustomValidity(mensagem)
}

function checaCPFRepetido(cpf){
    const valoresRepetidos = [
        '00000000000',
        '11111111111',
        '22222222222',
        '33333333333',
        '44444444444',
        '55555555555',
        '66666666666',
        '77777777777',
        '88888888888',
        '99999999999'
    ]

    let cpfValido = true

    valoresRepetidos.forEach(valor => {
        if(valor == cpf){
            cpfValido = false
        }
    })

    return cpfValido
}