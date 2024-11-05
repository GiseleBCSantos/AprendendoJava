$(function() {
    $('.js-decimal').maskMoney({thousands:'.', decimal:',', allowNegative:false});

    $('.js-plain').maskMoney({precision:0})

    $('#formCerveja').submit(function(e) {
        // Previne o envio do formulário para manipular os valores primeiro
        e.preventDefault();

        // Pega os valores limpos (sem máscara) dos campos
        var precoLimpo = $('#preco').maskMoney('unmasked')[0]; // Valor limpo de "preco"
        var comissaoLimpa = $('#comissao').maskMoney('unmasked')[0]; // Valor limpo de "comissao"
        var teorAlcoolicoLimpo = $('#teor_alcoolico').maskMoney('unmasked')[0]; // Valor limpo de "teorAlcoolico"
        var estoqueLimpo = $('#estoque').maskMoney('unmasked')[0]; // Valor limpo de "estoque"

        // Substitui os valores com máscara pelos valores limpos nos campos do formulário
        $('#preco').val(precoLimpo);
        $('#comissao').val(comissaoLimpa);
        $('#teor_alcoolico').val(teorAlcoolicoLimpo);
        $('#estoque').val(estoqueLimpo);

        // Agora você pode enviar o formulário com os valores limpos
        // Pode usar .submit() novamente para enviar o formulário
        this.submit();
    });
});


