import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Printador implements Runnable {

	private Double posicao_inicial_x; 
	private Double posicao_inicial_y; 
	private Double tamanho_x; 
	private Double tamanho_y;
	private Double tempo_repeticao; 
	private Double quantidade_repeticao; 
	private String nome_imagem;
	private String caminho_imagem;
	public int contador;
	
	
	public Printador(Double posicao_inicial_x, Double posicao_inicial_y, Double tamanho_x, Double tamanho_y, Double quantidade_repeticao,
			Double tempo_repeticao, String nome_imagem, String caminho_imagem) {
		super();
		this.posicao_inicial_x = posicao_inicial_x;
		this.posicao_inicial_y = posicao_inicial_y;
		this.tamanho_x = tamanho_x;
		this.tamanho_y = tamanho_y;
		this.tempo_repeticao = tempo_repeticao;
		this.quantidade_repeticao = quantidade_repeticao;
		this.nome_imagem = nome_imagem;
		this.caminho_imagem = caminho_imagem;
		this.contador = 0;
	}

	public void run() {
		printar();
	}

	public void printar() {
		try {
			while (contador < quantidade_repeticao) {
				Robot ro = new Robot();
				BufferedImage bi = ro.createScreenCapture(new Rectangle(posicao_inicial_x.intValue(), posicao_inicial_y.intValue(), 
						tamanho_x.intValue(), tamanho_y.intValue()));
				File outputfile = new File(caminho_imagem + nome_imagem + contador + ".jpg");
				ImageIO.write(bi, "jpg", outputfile);

				contador++;
				Thread.sleep(100 * tempo_repeticao.intValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
