package com.ism.repositories;

import java.util.ArrayList;

import com.ism.entities.AbstractEntities;


public interface ITables<pro extends AbstractEntities>{
   int insert (pro data) ;
   int update(pro data);

   ArrayList<pro>findAll ();
   pro findById (int id);
   int delete (int id);
   int indexOf(int id);
}
