var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {

    function MaskMoney(){
        this.decimal = $('.js-decimal')
        this.plain = $('.js-plain')
    }

    MaskMoney.prototype.enable = function() {
        this.decimal.maskMoney({decimal: ",", thousands: '.', allowNegative:false})
        this.plain.maskMoney({precision:0, thousands:'.'})
    }

    return MaskMoney;
}())

$(function(){
    var maskMoney = new Brewer.MaskMoney()
    maskMoney.enable()
})


// $(function() {
//     $('.js-decimal').maskMoney({thousands:'.', decimal:',', allowNegative:false});
//
//     $('.js-plain').maskMoney({precision:0, thousands:'.'})
//
// });


