## Run
## 'cd ~' 
## 'ln -f ~/Coding/fun/.zshrc ~/.zshrc' 

## Aliases
alias jupiter='cd ~/Music/Collab/JupiterBand'
alias root='cd ~'
alias coding='cd ~/Coding'
alias functions='cd ~/Coding/functions'
alias fun='cd ~/Coding/fun'
alias dnet='cd ~/Coding/dotnet'
alias vm='ssh -i ~/.ssh/KexueEA_key.pem azureuser@20.189.113.13'
alias dlsolutions='scp -i ~/.ssh/KexueEA_key.pem azureuser@20.189.113.13:~/coding/clrs4e-solutions/clrs4e-solutions.pdf clrs4e-solutions.pdf'

## Case-Insensitive
autoload -Uz compinit && compinit
zstyle ':completion:*' matcher-list 'm:{a-z}={A-Za-z}'

## Adding keyphrase to keychain
ssh-add --apple-use-keychain ~/.ssh/id_ed25519
# >>> conda initialize >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$('/Users/steven/miniconda3/bin/conda' 'shell.zsh' 'hook' 2> /dev/null)"
if [ $? -eq 0 ]; then
    eval "$__conda_setup"
else
    if [ -f "/Users/steven/miniconda3/etc/profile.d/conda.sh" ]; then
        . "/Users/steven/miniconda3/etc/profile.d/conda.sh"
    else
        export PATH="/Users/steven/miniconda3/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda initialize <<<

export PATH="/opt/homebrew/opt/mysql-client/bin:$PATH"
export PATH=$PATH:/usr/local/lib/node_modules/.bin
export PATH=$PATH:/usr/local/smlnj/bin

export NVM_DIR="$HOME/.nvm"
  [ -s "/opt/homebrew/opt/nvm/nvm.sh" ] && \. "/opt/homebrew/opt/nvm/nvm.sh"  # This loads nvm
  [ -s "/opt/homebrew/opt/nvm/etc/bash_completion.d/nvm" ] && \. "/opt/homebrew/opt/nvm/etc/bash_completion.d/nvm"  # This loads nvm bash_completion

