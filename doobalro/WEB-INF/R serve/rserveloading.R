install.packages('Rserve')
install.packages("plotrix")
install.packages('ggmap')
install.packages("devtools")
devtools::install_github("cardiomoon/Kormaps")
install.packages('dplyr')

library(Rserve)
# ?Rserve

# Rserve(debug = F, port = 6311, args='--no-save')

Rserve(debug = F, port=4321, args='--RS-encoding utf8 --no-save --encoding utf8 --RS-enable-remote')




