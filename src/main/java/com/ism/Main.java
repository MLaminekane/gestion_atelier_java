package com.ism;

import java.util.Scanner;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import com.ism.repositories.list.TableArticleConfections;
import com.ism.repositories.list.TableCategories;
import com.ism.services.*;

public class Main {
    private static final Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        ITables<Categorie> repository=new TableCategories();
        CategorieService categorieServiceImpl = new CategorieServiceImpl(repository);

        IService<ArticleConfection> repositoryy = new TableArticleConfections();
        ArticleConfectionService articleConfectionServiceImpl = new ArticleConfectionServiceImpl(repositoryy);
        int choix;
        do {
            System.out.println("-------MENU GENERAL-------");
            System.out.println("1. Categorie");
            System.out.println("2. Article Confection");
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    do {
                        System.out.println("-------MENU GENERAL-------");
                        System.out.println("1----Ajouter categorie");
                        System.out.println("2----Lister les categories");
                        System.out.println("3----Editer categorie");
                        System.out.println("4----Supprimer categorie");
                        System.out.println("5----Rechercher categorie");
                        System.out.println("6----Quitter");
                        choix=sc.nextInt();
                        sc.nextLine();
                        switch(choix){
                            case 1:
                                effacer();
                                System.out.println("Entrer le libelle :");
                                Categorie categorie = new Categorie(sc.nextLine());
                                categorieServiceImpl.add(categorie);
                                break;
                            case 2:
                                effacer();
                                System.out.println("Liste des catégories :");
//                    categorieServiceImpl.getAll().forEach(System.out::println);
                                categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
                                break;
                            case 3:
                                effacer();
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
                                effacer();
                                System.out.println("Liste des catégories :");
                                categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
                                System.out.println("1.Supprimer une Categorie - 2.Supprimer plusieurs categories ");
                                int idSupp = sc.nextInt();
                                sc.nextLine();
                                switch (idSupp) {
                                    case 1:
                                        effacer();
                                        System.out.println("Entrer l'id de la categorie a supprimer: ");
                            int categorieToDelete = sc.nextInt();
                            int rm = categorieServiceImpl.remove(categorieToDelete);
                            if (rm == 1) {
                                System.out.println("La categorie a été supprimée.");
                            } else {
                                System.out.println("ID categorie introuvable");
                            }
//                                        categorieServiceImpl.getAll().forEach(cat -> System.out.println(cat.getId() + ". " + cat.getLibelle()));
//                                        System.out.println("Entrer l'id: ");
//                                        idSupp=sc.nextInt();
//                                        categorieServiceImpl.remove(idSupp=1);
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
                                effacer();
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
                            default:
                                System.exit(3);
                                break;
                        }
                    } while (true);
                case 2:
                    do{
                        System.out.println("-------MENU GENERAL-------");
                        System.out.println("1----Ajouter article Confection");
                        System.out.println("2----Lister les articles conffection");
                        System.out.println("3----Editer article confection");
                        System.out.println("4----Supprimer article confection");
                        System.out.println("5----Rechercher article confection");
                        System.out.println("6----Quitter");
                        choix=sc.nextInt();
                        switch (choix){
                            case 1:
                                System.out.println("Ajouter un article de confection :");
                                System.out.print("Entrer le libellé de l'article : ");
                                String libelle = sc.nextLine();
                                sc.nextLine();
                                System.out.print("Entrer le prix de l'article : ");
                                double prix = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Entrer la quantité en stock : ");
                                double qte = sc.nextDouble();
                                ArticleConfection nouvelArticle = new ArticleConfection(libelle);
                                nouvelArticle.setPrix(prix);
                                nouvelArticle.setQte(qte);
                                articleConfectionServiceImpl.add(nouvelArticle);
                                System.out.println("Article ajouté avec succès !");
                                break;

                            case 2:
                                effacer();
                                System.out.println("Liste des articles confection :");
                                articleConfectionServiceImpl.getAll().forEach(art -> System.out.println(art.getId() + ". " + art.getLibelle() + ". " + art.getPrix() + ". " + art.getQte()));
                                break;
                            case 3:

                            default:
                                break;
                        }
                        sc.nextLine();
                    }while (true);
                default:
                    break;
            }
        }while (true);
    }
    public static void effacer(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}
       