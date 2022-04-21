# Classe base para o Subject
class Subject
    # Método para adicionar um observer
    def attach (observer)
        raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
    end

    # Método para remover um observer
    def detach (observer)
        raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
    end

    # Método para notificar os observers
    def notify (observer)
        raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
    end
end

# Classe base para o Observer
class Observer
    # Método para atualizar o observer após uma notificação do subject
    def update (subject)
        raise NotImplementedError, "#{self.class} has not implemented method '#{__method__}'"
    end
end

# Classe para gerar um preço aleatório no intervalo [60, 140)
class Price
    def self.fetch
        60 + rand(80)
    end
end

# Class Ticker que será o subject nesse exemplo
class Ticker < Subject
    # Inicializa o vetor de observers
    def initialize
        @observers = []
    end

    # Adiciona um observer na lista de observers
    def attach (observer)
        puts 'Attached an observer.'
        @observers << observer
    end

    # Remove um observer da lista de observers
    def detach (observer)
        puts 'Detached an observer.'
        @observers.delete(observer)
    end

    # Notifica todos os observers enviando o preço atual
    def notify (price)
        puts 'Notifying observers...'
        @observers.each { |observer| observer.update(price) }
    end

    # Função que fara o subject ser executado
    def run
        last_price = nil

        # Loop infinito
        loop do
            # Pega um novo preço
            price = Price.fetch
            print "\nCurrent price: #{price}\n"

            # Notifica os observers se o preço mudar
            if price != last_price
                last_price = price
                notify(price)
            end
            
            # Aguarda 1 segundo para a próxima execução
            sleep 1
        end
    end
end

# Classe Warner que herdará de Observer
class Warner < Observer
    # Inicializa o valor do limite
    def initialize (limit)
        @limit = limit
    end
end

# Classe que herda de Warner e avisa quando o preço estiver abaixo de um limite inferior
class WarnLow < Warner
    # Verifica se o preço está abaixo do limite inferior e imprime junto com a hora atual
    def update (price)
        if price < @limit
            print "\n--- #{Time.now.to_s}: Price below #@limit: #{price}\n"
        end
    end
end

# Classe que herda de Warner e avisa quando o preço estiver acima de um limite superior
class WarnHigh < Warner
    # Verifica se o preço está acima do limite superior e imprime junto com a hora atual
    def update (price)
        if price > @limit
            print "\n--- #{Time.now.to_s}: Price above #@limit: #{price}\n"
        end
    end
end

# Inicialização do subject e dos observers
ticker = Ticker.new
warn_low = WarnLow.new(80)
warn_high = WarnHigh.new(120)

# Adição dos observers ao subject
ticker.attach(warn_low)
ticker.attach(warn_high)

# O ticker passará a rodar
ticker.run