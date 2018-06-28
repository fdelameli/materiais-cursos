package br.unisul.aula.banco.dao;


public class DAOException extends Exception
{
  private Throwable cause;
  
  public DAOException( )
  {
  }
  
  public DAOException(Throwable c)
  {
    cause = c;
  }


  public void setCause(Throwable cause)
  {
    this.cause = cause;
  }


  public Throwable get_cause()
  {
    return cause;
  }

  
}