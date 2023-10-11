package com.ism;

import java.util.Scanner;
import java.util.ArrayList;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import com.ism.repositories.bd.ArticleRepository;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.list.TableArticleConfections;
import com.ism.repositories.list.TableCategories;
import com.ism.services.*;

public class Main {
    private static final Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        ITables<Categorie> repository=new CategorieRepository();
        ITables<ArticleConfection> article=new ArticleRepository();
        CategorieService categorieServiceImpl = new CategorieServiceImpl(repository);
        ArticleConfectionService articleConfectionServiceImpl = new ArticleConfectionServiceImpl(article);
        int choix = 0;
        do {
            System.out.println("-------Gestion Couture Java-------");
            System.out.println("1. Categorie");
            System.out.println("2. Article Confection");
            System.out.println("3. Quitter");
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    int categorieChoix;
                    do {
                        System.out.println("-------MENU CATEGORIES-------");
                        System.out.println("1. Ajouter categorie");
                        System.out.println("2. Lister les categories");
                        System.out.println("3. Editer categorie");
                        System.out.println("4. Supprimer categorie");
                        System.out.println("5. Rechercher categorie");
                        System.out.println("6. Retour au menu principal");
                        System.out.println("7. Quitter");
                        categorieChoix = sc.nextInt();
                        sc.nextLine();
                        switch(categorieChoix){
                            case 1:
                                System.out.println("Entrer le libelle :");
                                Categorie categorie = new Categorie(sc.nextLine());
                                categorieServiceImpl.add(categorie);
                                break;
                            case 2:
                                System.out.println("Liste des catégories :");
                                categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
                                break;
                            case 3:
                                System.out.println("Liste des catégories :");
                                categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
                                System.out.print("Entrez l'ID de la catégorie à éditer : ");
                                int idToEdit = sc.nextInt();
                                sc.nextLine();
                                Categorie categorieToEdit = categorieServiceImpl.show(idToEdit);
                                if (categorieToEdit != null){
                                    System.out.println("La catégorie sélectionnée : " + categorieToEdit.getLibelle());
                                    System.out.println("Nouveau libellé : ");
                                    String newLibelle = sc.nextLine();
                                    categorieToEdit.setLibelle(newLibelle);
                                    categorieServiceImpl.update(categorieToEdit);
                                    System.out.println("Catégorie éditée avec succès.");
                                } else {
                                    System.out.println("ID de catégorie introuvable.");
                                }
                                break;
                            case 4:
                                System.out.println("Liste des catégories :");
                                categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
                                System.out.println("1.Supprimer une Categorie - 2.Supprimer plusieurs categories ");
                                int idSupp = sc.nextInt();
                                sc.nextLine();
                                switch (idSupp) {
                                    case 1:
                                        System.out.println("Entrer l'id de la categorie a supprimer: ");
                                        int categorieToDelete = sc.nextInt();
                                        int rm = categorieServiceImpl.remove(categorieToDelete);
                                        if (rm == 1) {
                                            System.out.println("La categorie a été supprimée.");
                                        } else {
                                            System.out.println("ID categorie introuvable");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Entrer les ids à supprimer séparés par des espaces : ");
                                        String deleteMCategorie = sc.nextLine();
                                        String[] multipleToDelete = deleteMCategorie.split(" ");
                                        int[] idsToDelete = new int[multipleToDelete.length];
                                        for (int i = 0; i < multipleToDelete.length; i++) {
                                            try {
                                                idsToDelete[i] = Integer.parseInt(multipleToDelete[i]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("ID non valide : " + multipleToDelete[i]);
                                            }
                                        }
                                        if (idsToDelete.length > 0) {
                                            int[] deletedIds = categorieServiceImpl.remove(idsToDelete);
                                            System.out.println("Catégories supprimées.");
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 5:
                                System.out.println("Entrer l'id que vous souhaitez rechercher : ");
                                int idSearch = sc.nextInt();
                                sc.nextLine();
                                Categorie search = categorieServiceImpl.show(idSearch);
                                if (search != null) {
                                    System.out.println("Catégorie trouvée: " + search.getId() + "." + search.getLibelle());
                                } else {
                                    System.out.println("Aucune catégorie trouvée" + idSearch);
                                }
                                break;
                            case 6:
                                break;
                            case 7:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Choix invalide.");
                                break;
                        }
                    } while(categorieChoix!=6);
                case 2:
                    int articleChoix;
                    do {
                        System.out.println("-------MENU ARTICLES CONFECTION-------");
                        System.out.println("1. Ajouter article Confection");
                        System.out.println("2. Lister les articles confection");
                        System.out.println("3. Editer article confection");
                        System.out.println("4. Supprimer article confection");
                        System.out.println("5. Rechercher article confection");
                        System.out.println("6. Retour au menu principal");
                        System.out.println("7. Quitter");
                        articleChoix = sc.nextInt();
                        sc.nextLine();
                        switch (articleChoix) {
                            case 1:
                                System.out.println("Entrer l'id de la categorie: ");
                                int categorieId = sc.nextInt();
                                sc.nextLine();
                                Categorie selectedCategorie = categorieServiceImpl.show(categorieId);
                                if (selectedCategorie != null) {
                                    System.out.println("Libellé de la catégorie associée à l'article : " + selectedCategorie.getLibelle());
                                    ArticleConfection articleConfection = new ArticleConfection();
                                    System.out.println("Entrer le libellé: ");
                                    String libelle = sc.nextLine();
                                    System.out.println("Entrer le prix: ");
                                    double prix = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Entrer la quantité: ");
                                    double qte = sc.nextDouble();
                                    sc.nextLine();
                                    articleConfection.setLibelle(libelle);
                                    articleConfection.setPrix(prix);
                                    articleConfection.setQte(qte);
                                    articleConfection.setCategorie(selectedCategorie);
                                    articleConfection.setCatLibelle(selectedCategorie.getLibelle());
                                    articleConfectionServiceImpl.add(articleConfection);
                                    System.out.println("Article de confection ajouté avec succès.");
                                } else {
                                    System.out.println("ID de catégorie introuvable. L'article de confection n'a pas été ajouté.");
                                }
                                break;
                            case 2:
                                System.out.println("Liste des articles confection :");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                break;
                            case 3:
                                System.out.println("Editer un article confection");
                                System.out.println("Liste des articles :");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrez l'ID de l'article à éditer : ");
                                int articleIdToEdit = sc.nextInt();
                                sc.nextLine();
                                ArticleConfection articleToEdit = articleConfectionServiceImpl.show(articleIdToEdit);
                                if (articleToEdit != null) {
                                    System.out.println("Article sélectionné : " + articleToEdit.getLibelle());
                                    System.out.print("Nouveau libellé : ");
                                    String newLibelle = sc.nextLine();
                                    System.out.print("Nouveau prix : ");
                                    int newPrix = sc.nextInt();
                                    System.out.print("Nouvelle quantité : ");
                                    int newQte = sc.nextInt();
                                    articleToEdit.setLibelle(newLibelle);
                                    articleToEdit.setPrix(newPrix);
                                    articleToEdit.setQte(newQte);
                                    articleConfectionServiceImpl.update(articleToEdit);
                                    System.out.println("Article édité avec succès.");
                                } else {
                                    System.out.println("ID d'article introuvable.");
                                }
                                break;
                            case 4:
                                System.out.println("Supprimer un article confection");
                                System.out.println("Liste des articles :");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrez l'ID de l'article à supprimer : ");
                                int articleIdToDelete = sc.nextInt();
                                sc.nextLine();
                                int removalResult = articleConfectionServiceImpl.remove(articleIdToDelete);
                                if (removalResult == 1) {
                                    System.out.println("L'article a été supprimé.");
                                } else {
                                    System.out.println("ID d'article introuvable.");
                                }
                                break;
                            case 5:
                                System.out.println("Entrer l'id que vous souhaitez rechercher : ");
                                int idSearch = sc.nextInt();
                                sc.nextLine();
                                ArticleConfection search = articleConfectionServiceImpl.show(idSearch);
                                if (search != null) {
                                    System.out.println("Article trouvé: " +"ID: " + search.getId() + ", Libelle: " + search.getLibelle() + ", Prix: " + search.getPrix() + ", Quantite: " + search.getQte());
                                } else {
                                    System.out.println("Aucun article trouvé" + idSearch);
                                }
                                break;
                            case 6:
                                break;
                            case 7:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Choix invalide.");
                                break;
                        }
                    } while (articleChoix != 6);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }while (true);
    }
}