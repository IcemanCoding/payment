package com.juxinli.payment.core.utils.codec;

import com.juxinli.payment.core.exception.DecoderException;

public interface Decoder {

	Object decode( Object pObject ) throws DecoderException;

}
