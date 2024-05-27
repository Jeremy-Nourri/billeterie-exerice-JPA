package org.example.Repository;

import org.example.Entity.Client;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class ClientRepository extends BaseRepository<Client> {

    public ClientRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Client element) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(element);
                transaction.commit();
            } catch (PersistenceException  e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException("Erreur lors de la sauvegarde du client", e);
            }
    }

    @Override
    public Client update(Client element) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Client updatedClient = em.merge(element);
            transaction.commit();
            return updatedClient;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erreur lors de la mise à jour du client", e);
        }
    }

    @Override
    public void delete(Client element) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(element);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erreur lors de la suppression du client", e);
        }
    }

    @Override
    public Client get(int id) {
        try {
            return em.find(Client.class, id);
        } catch (PersistenceException  e) {
            throw new RuntimeException("Erreur lors de la récupération du client avec l'ID " + id, e);
        }
    }

    @Override
    public List<Client> get() {
        try {
            return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        } catch (PersistenceException e) {
            throw new RuntimeException("Erreur lors de la récupération de la liste des clients", e);
        }
    }
}
