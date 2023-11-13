package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar {

    private int[] array;
    private int tamanho;
    private int indice_fim;

    public ListaArray(int tamanho) {
        this.tamanho = tamanho;
        array = new int[tamanho];
        indice_fim = 0;
    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int minimo() {
        if (indice_fim == 0) {
            throw new IllegalStateException("A lista está vazia.");
        }

        int min = array[0];
        for (int i = 1; i < indice_fim; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int maximo() {
        if (indice_fim == 0) {
            throw new IllegalStateException("A lista está vazia.");
        }

        int max = array[0];
        for (int i = 1; i < indice_fim; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {
        int indice = buscaIndice(valor);
        if (indice == -1) {
            throw new IllegalArgumentException("O valor não está na lista.");
        }

        if (indice == 0) {
            throw new IllegalArgumentException("Não há predecessor, pois o valor está na primeira posição.");
        }

        return array[indice - 1];
    }

    @Override
    public int sucessor(int valor) {
        int indice = buscaIndice(valor);
        if (indice == -1) {
            throw  new IllegalArgumentException("O valor não está na lista.");
        }

        if (indice == indice_fim - 1) {
            throw new IllegalArgumentException("Não há sucessor, pois o valor está na última posição.");
        }

        return array[indice + 1];
    }

    @Override
    public void insereElemento(int valor) {
        if (indice_fim == tamanho) {
            throw new IllegalStateException("A lista está cheia.");
        }

        array[indice_fim] = valor;
        indice_fim++;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice < 0 || buscaIndice > indice_fim) {
            throw new IllegalArgumentException("Posição de inserção inválida.");
        }

        if (indice_fim == tamanho) {
            throw new IllegalStateException("A lista está cheia.");
        }

        for (int i = indice_fim; i > buscaIndice; i--) {
            array[i] = array[i - 1];
        }

        array[buscaIndice] = valor;
        indice_fim++;
    }

    @Override
    public void insereInicio(int valor) {
        insereElementoPosicao(valor, 0);
    }

    @Override
    public void insereFim(int valor) {
        insereElemento(valor);
    }

    @Override
    public void remove(int valor) {
        int indice = buscaIndice(valor);
        if (indice == -1) {
            return;
        }

        for (int i = indice; i < indice_fim - 1; i++) {
            array[i] = array[i + 1];
        }

        indice_fim--;
    }

    @Override
    public void removeIndice(int indice) {
        if (indice < 0 || indice >= indice_fim) {
            return;
        }
        

        for (int i = indice; i < indice_fim - 1; i++) {
            array[i] = array[i + 1];
        }

        indice_fim--;
    }

    @Override
    public void removeInicio() {
        if (indice_fim == 0) {
            return;
        }

        removeIndice(0);
    }

    @Override
    public void removeFim() {
        if (indice_fim == 0) {
            return;
        }

        removeIndice(indice_fim - 1);
    }
}
