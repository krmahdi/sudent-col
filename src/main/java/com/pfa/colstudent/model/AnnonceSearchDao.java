package com.pfa.colstudent.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AnnonceSearchDao {
    @Autowired
    private EntityManager em;
    /*  public List<Annonce> FindAllBySimpleQuery(String description, float superficie , double loyer , int nbChambre, int nbPersonne, boolean animeaux, boolean fumeurs, String adresse){
        CriteriaBuilder cr= em.getCriteriaBuilder();
        CriteriaQuery<Annonce> cQ= cr.createQuery(Annonce.class);
        Root<Annonce> root =cQ.from( Annonce.class );
        Predicate descriptionPredicate =cr.like(root.get( "description"), "%" + description + "%" );
        Predicate superficiePredicate =cr.between (root.get( "superficie"), superficie +1,superficie-1 );
        Predicate loyerPredicate =cr.like(root.get( "loyer"), "%" + loyer + "%" );
        Predicate nbChambrePredicate =cr.like(root.get( "nbChambre"), "%" + nbChambre + "%" );
        Predicate nbPersonnePredicate =cr.like(root.get( "nbPersonne"), "%" + nbPersonne + "%" );
        Predicate animeauxPredicate =cr.like(root.get( "animeaux"), "%" + animeaux + "%" );
        Predicate fumeursPredicate =cr.like(root.get( "fumeurs"), "%" + fumeurs + "%" );
        Predicate orPredicate = cr.or(descriptionPredicate,superficiePredicate,loyerPredicate,nbChambrePredicate,nbPersonnePredicate,animeauxPredicate,fumeursPredicate );
        TypedQuery<Annonce> query =em.createQuery( cQ );
        return query.getResultList();
    }*/
  public List<Annonce> findAllByCriteria(Annonce request){
        CriteriaBuilder cr=em.getCriteriaBuilder();
        CriteriaQuery<Annonce> cQ=cr.createQuery(Annonce.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<Annonce> root = cQ.from(Annonce.class);
        if(request.getDescription()!=null){
            Predicate descriptionPredicate=cr.like(root.get( "description"),"%"+request.getDescription( )+"%");
            predicates.add(descriptionPredicate);
        }
        if(request.getSuperficie()!=0.0){
            Predicate superficiePredicate=cr.equal(root.get( "superficie"),request.getSuperficie( ));
            predicates.add(superficiePredicate);
        }
        if(request.getLoyer()!=0.0){
            Predicate loyerPredicate=cr.equal(root.get( "loyer"),request.getLoyer( ));
            predicates.add(loyerPredicate);
        }
        if(request.getNbChambre()!=0.0){
            Predicate nbChambrePredicate=cr.equal(root.get( "nbChambre"),request.getNbChambre( ));
            predicates.add(nbChambrePredicate);
        }
        if(request.getNbPersonne()!=0){
            Predicate nbPersonnePredicate=cr.equal(root.get( "nbPersonne"),request.getNbPersonne());
            predicates.add(nbPersonnePredicate);
        }
      if(request.isAnimeaux()==true){
          Predicate animeauxPredicate=cr.isTrue(root.get( "animeaux"));
          predicates.add(animeauxPredicate);
      }
      if(request.isFumeurs()==true){
          Predicate fumeursPredicate=cr.isFalse(root.get( "fumeurs"));
          predicates.add(fumeursPredicate);
      }
        cQ.where(cr.or(predicates.toArray(new Predicate[0])));
TypedQuery<Annonce> query = em.createQuery( cQ );
return query.getResultList();

    }
}
