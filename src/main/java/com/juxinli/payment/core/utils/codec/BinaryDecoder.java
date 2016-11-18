package com.juxinli.payment.core.utils.codec;

import com.juxinli.payment.core.exception.DecoderException;

public interface BinaryDecoder extends Decoder {

	byte[] decode( byte[] pArray ) throws DecoderException;

}
