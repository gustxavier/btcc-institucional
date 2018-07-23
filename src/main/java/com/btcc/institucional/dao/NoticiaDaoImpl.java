package com.btcc.institucional.dao;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Noticia;

@Repository
public class NoticiaDaoImpl extends AbstractDao<Noticia, BigInteger> implements NoticiaDao {

}
