$(function() {
    $('.js-decimal').maskMoney({thousands:'.', decimal:',', allowNegative:false});

    $('.js-plain').maskMoney({precision:0})
});