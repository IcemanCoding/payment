package com.juxinli.payment.core.utils.codec;

import com.juxinli.payment.core.exception.EncoderException;

public interface Encoder {

	Object encode( Object pObject ) throws EncoderException;

}
