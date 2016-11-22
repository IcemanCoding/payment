package com.juxinli.payment.core.utils.codec;

import com.juxinli.payment.core.exception.EncoderException;

public interface BinaryEncoder extends Encoder {

	byte[] encode( byte[] pArray ) throws EncoderException;

}
