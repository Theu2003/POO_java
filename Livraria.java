import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Livraria {
    private List<Livro> livros = new ArrayList<>();

    public int incluirLivro(Livro livro) {
        for (Livro l : livros) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                return 0;
            }
        }
        livros.add(livro);
        return 1;
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros(int ano) {
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() >= ano) {
                System.out.println(livro);
            }
        }
    }

    public int excluirLivro(String isbn) {
        Iterator<Livro> iterator = livros.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Livro livro = iterator.next();

            if (livro.getIsbn().equalsIgnoreCase(isbn)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            return 1;
        } else {
            return 0;
        }
    }
}